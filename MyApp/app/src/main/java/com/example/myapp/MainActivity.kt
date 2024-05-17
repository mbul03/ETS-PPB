package com.example.myapp
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.ui.text.font.FontWeight
import android.content.res.Configuration.UI_MODE_NIGHT_YES

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldLogIn by rememberSaveable { mutableStateOf(true) }
    var shouldHome by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldLogIn) {
            LoginScreen(onContinueClicked = { shouldLogIn = false })
        } else if (shouldHome) {
            HomeScreen(onContinueClicked = { shouldHome = false })
        } else{
            JadwalScreen(onContinueClicked = {})
        }
    }

}

@Preview
@Composable
fun MyAppPreview() {
    MyAppTheme {
        MyApp(modifier = Modifier.fillMaxSize())
    }
}


@Composable
fun LoginScreen(onContinueClicked: () -> Unit,
                     modifier: Modifier = Modifier) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Image(
        painter = painterResource(id = R.drawable.bglog),
        contentDescription = "login image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Text("Welcome", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Text(text = "Mahasiswa ITS", fontSize = 32.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(120.dp))

        SelectionContainer(Modifier.width(275.dp)) {
            Text(text = "MyITS ID")
        }
        OutlinedTextField(value = email, onValueChange = {email = it}, placeholder = { Text(text = "example@student.its.ac.id")})

        Spacer(modifier = Modifier.height(20.dp))

        SelectionContainer(Modifier.width(275.dp)) {
            Text(text = "Password")
        }
        OutlinedTextField(value = password, onValueChange = {password = it}, placeholder = { Text(text = "********")}, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = onContinueClicked,
            colors = ButtonDefaults.buttonColors(containerColor = Color(33,130,171))
        ) {
            Text("Log In", color = Color.White)
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Forgot Password?")
        }
        Button(
            onClick = onContinueClicked,
            colors = ButtonDefaults.buttonColors(containerColor = Color(74,167,219))
        ) {
            Text("Sign In", color = Color.White)
        }
    }
}

@Composable
fun HomeScreen(onContinueClicked: () -> Unit,
                modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(id = R.drawable.bg_menu),
        contentDescription = "login image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Row {
            SelectionContainer(
                Modifier
                    .width(300.dp)
                    .height(95.dp)){
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text("Welcome Marsyavero", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Vivat ITS!!", fontSize = 14.sp)
                    Divider(color = Color(74,167,219), thickness = 1.dp, modifier = Modifier
                        .width(300.dp)
                        .padding(vertical = 7.dp))

                    Row() {
                        Text(text = "5025201122", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "Teknik Informatika", fontSize = 14.sp)
                    }
                }
            }
            Image(painter = painterResource(id = R.drawable.bell), contentDescription = "notif", modifier = Modifier
                .size(25.dp)
                .clickable {})
            Spacer(modifier = Modifier.width(5.dp))
            Image(painter = painterResource(id = R.drawable.account), contentDescription = "account", modifier = Modifier
                .size(25.dp)
                .clickable {})
        }


        Spacer(modifier = Modifier.height(60.dp))
        SelectionContainer(modifier = Modifier
            .background(Color(74,167,219))
            .padding(7.dp)) {
            Row {
                Column(modifier = Modifier.padding(vertical = 20.dp)) {
                    Text(text = "IPK saat ini", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                    Text(text = "3.59", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(10.dp))

                SelectionContainer(
                    Modifier
                        .width(300.dp)
                        .height(95.dp)){
                    Column(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp),
                    ){
                        Text("Semester 8 2023/2024", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                        Text(text = "Kurikulum 2023", fontSize = 12.sp)
                        Divider(color = Color(274,167,219), thickness = 1.dp, modifier = Modifier
                            .width(300.dp)
                            .padding(vertical = 7.dp))

                        Column() {
                            Text(text = "Status Pembayaran UKT", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = "LUNAS", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }
        }



        Spacer(modifier = Modifier.height(60.dp))

        Row {
            Image(painter = painterResource(id = R.drawable.cal), contentDescription = "calender", modifier = Modifier.size(50.dp))
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Jadwal Kuliah", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(vertical = 7.dp))
            Spacer(modifier = Modifier.width(117.dp))
            Image(painter = painterResource(id = R.drawable.buka), contentDescription = "calender", modifier = Modifier.size(25.dp).clickable { onContinueClicked() })
        }
        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Image(painter = painterResource(id = R.drawable.track), contentDescription = "track", modifier = Modifier.size(50.dp))
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Kemajuan Studi", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(vertical = 7.dp))
            Spacer(modifier = Modifier.width(101.dp))
            Image(painter = painterResource(id = R.drawable.buka), contentDescription = "open", modifier = Modifier.size(25.dp))
        }
        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Image(painter = painterResource(id = R.drawable.transkrip), contentDescription = "transcript", modifier = Modifier.size(50.dp))
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Transkrip", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(vertical = 7.dp))
            Spacer(modifier = Modifier.width(161.dp))
            Image(painter = painterResource(id = R.drawable.buka), contentDescription = "open", modifier = Modifier.size(25.dp))
        }

    }
}

@Preview()
@Composable
fun HomePreview() {
    MyAppTheme {
        HomeScreen(onContinueClicked = {})
    }
}


@Composable
fun JadwalScreen(onContinueClicked: () -> Unit,
               modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(id = R.drawable.bg_menu),
        contentDescription = "login image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Row {
            SelectionContainer(
                Modifier
                    .width(300.dp)
                    .height(95.dp)){
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text("Welcome Marsyavero", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Vivat ITS!!", fontSize = 14.sp)
                    Divider(color = Color(74,167,219), thickness = 1.dp, modifier = Modifier
                        .width(300.dp)
                        .padding(vertical = 7.dp))

                    Row() {
                        Text(text = "5025201122", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "Teknik Informatika", fontSize = 14.sp)
                    }
                }
            }
            Image(painter = painterResource(id = R.drawable.bell), contentDescription = "notif", modifier = Modifier
                .size(25.dp)
                .clickable {})
            Spacer(modifier = Modifier.width(5.dp))
            Image(painter = painterResource(id = R.drawable.account), contentDescription = "account", modifier = Modifier
                .size(25.dp)
                .clickable {})
        }


        Spacer(modifier = Modifier.height(60.dp))
        SelectionContainer(modifier = Modifier.fillMaxWidth()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Jadwal Kuliah", fontSize = 20.sp, fontWeight = FontWeight.Medium)
            }
        }


        Spacer(modifier = Modifier.height(60.dp))

        Row {
            Text(text = "Rabu", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.width(25.dp))
            Divider(modifier = Modifier
                .width(1.dp)
                .height(30.dp))
            Spacer(modifier = Modifier.width(20.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Kualitas Perangkat Lunak", fontSize = 15.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(vertical = 5.dp))
                Text(text = "10.00 - 11.50", fontSize = 12.sp, fontWeight = FontWeight.Normal)
                Text(text = "IF 101", fontSize = 12.sp, fontWeight = FontWeight.Normal)
            }
        }
        Spacer(modifier = Modifier.height(25.dp))

        Divider(color = Color(74,167,219), thickness = 1.dp, modifier = Modifier
            .width(500.dp)
            .padding(vertical = 10.dp)
        )

        Row {
            Text(text = "Rabu", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.width(25.dp))
            Divider(modifier = Modifier
                .width(1.dp)
                .height(30.dp))
            Spacer(modifier = Modifier.width(20.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Pemrograman Perangkat Bergerak", fontSize = 15.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(vertical = 5.dp))
                Text(text = "13.30 - 15.20", fontSize = 12.sp, fontWeight = FontWeight.Normal)
                Text(text = "IF 101", fontSize = 12.sp, fontWeight = FontWeight.Normal)
            }
        }
        Spacer(modifier = Modifier.height(25.dp))

        Divider(color = Color(74,167,219), thickness = 1.dp, modifier = Modifier
            .width(500.dp)
            .padding(vertical = 10.dp)
        )



    }
}

@Preview()
@Composable
fun JadwalPreview() {
    MyAppTheme {
        JadwalScreen(onContinueClicked = {})
    }
}