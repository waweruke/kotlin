package com.example.reaganregisterapp

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reaganregisterapp.ui.theme.ButtonGreen
import com.example.reaganregisterapp.ui.theme.ReaganRegisterAppTheme
import com.example.reaganregisterapp.ui.theme.TitleOrange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReaganRegisterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Register()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
var context = LocalContext.current
        Text(
    text = "Register Here",
    color = TitleOrange,
    fontWeight = FontWeight.Bold,
    fontSize = 40.sp,
    fontFamily = FontFamily.Cursive,
    textDecoration = TextDecoration.Underline,
    modifier = Modifier
        .padding(0.dp, 0.dp, 0.dp, 20.dp)
)
Image(
    painter = painterResource(id = R.drawable.pic),
    contentDescription = null,
    modifier = Modifier
        .width(180.dp)
        .height(180.dp)
)

    var name by remember{ mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
        value = name,
        onValueChange = {name = it },
        label = {Text(text = "Enter name")},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )

Spacer(modifier = Modifier.height(16.dp))

        var email by remember{ mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = email,
            onValueChange = {email = it },
            label = {Text(text = "Enter email")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        var idNumber by remember{ mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = idNumber,
            onValueChange = {idNumber = it },
            label = {Text(text = "Enter idNumber")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        var password by remember{ mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = password,
            onValueChange = {password = it },
            label = {Text(text = "Enter password...")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            
            Toast.makeText(context, "You've registered as ${name.text}", Toast.LENGTH_SHORT).show()
        }, colors = ButtonDefaults.buttonColors(ButtonGreen),
            shape = CutCornerShape(10.dp)) {
            Text(text = "Register")

            Spacer(modifier = Modifier.height(16.dp))

            ClickableText(
                text = AnnotatedString("Login instead"),
                onClick = {
                          context.startActivity(Intent(context,SecondActivity::class.java))
                },
                style = TextStyle(
                    color = TitleOrange,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Cursive
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReaganRegisterAppTheme {
        Register()
    }
}