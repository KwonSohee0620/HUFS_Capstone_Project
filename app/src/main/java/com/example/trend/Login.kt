package com.example.trend

import android.content.ContentValues.TAG
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONException
import org.json.JSONObject


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val id : EditText = findViewById<EditText>(R.id.edit_id)
        val pw : EditText = findViewById<EditText>(R.id.edit_pw)

        btn_register.setOnClickListener(){
            val intent = Intent(this,Login2::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener(){
            var userID: String = id.text.toString()
            var userPW: String = pw.text.toString()
            var requestQueue: RequestQueue?=null

            val url: String = "http://localhost/login.php";
            requestQueue= Volley.newRequestQueue(applicationContext)

            loginVolley(this, url, userID, userPW)

            if(userID=="yewon" && userPW=="0522"){
                dialog("success")
            }
            else{
                dialog("fail")
            }

        }
    }
    private fun loginVolley(context: Context, url: String, userid: String, password: String) {

        // 1. RequestQueue 생성 및 초기화
        val requestQueue = Volley.newRequestQueue(context)

        // 2. Request Obejct인 StringRequest 생성
        val request: StringRequest = object : StringRequest(Method.POST, url,
            Response.Listener { response ->
                showJSONList(response)
            },
            Response.ErrorListener { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }
        ) {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String,String> = HashMap()
                params["userid"] = userid
                params["password"] = password
                params["uID"] = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
                return params
            }
        }
        requestQueue.add(request)
    }

    fun showJSONList(response: String) {
        try {
            Log.e("TAG",response)
            val jsonObject = JSONObject(response)
            jsonObject.let {
                if(it.getString("userinfo") == null) {
                    //showAlert(it.getString("result").toString(), it.getString("message").toString())
                } else {
                    if(it.getString("result").toString().equals("success")){
                        val jsonInfo = JSONObject(it.getString("userinfo").toString())
                        jsonInfo.let{
                            // Preference 에 대한 정보 기록은 생략한다.
                            startActivity(Intent(this,MainActivity::class.java))
                        }
                    }
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    fun dialog(type: String){
        var dialog = AlertDialog.Builder(this)

        if(type.equals("success")){
            dialog.setTitle("로그인 성공")
            dialog.setMessage("로그인 성공!")
        }
        else if(type.equals("fail")){
            dialog.setTitle("로그인 실패")
            dialog.setMessage("아이디와 비밀번호를 확인해주세요")
        }

        var dialog_listener = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which){
                    DialogInterface.BUTTON_POSITIVE ->
                        Log.d(TAG, "")
                }
            }
        }

        dialog.setPositiveButton("확인",dialog_listener)
        dialog.show()
    }
}