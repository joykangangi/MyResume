package com.example.myresume

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.myresume.ui.theme.MyResumeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyResumeTheme {

            }
        }
    }
}

@Composable
fun ResumeDetails(modifier: Modifier = Modifier) {

    val scrollState = rememberScrollState() //for tiny screens
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Magenta)
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier
                    .clip(shape = CircleShape)
                    .size(150.dp),
                painter = painterResource(id = R.drawable.joy_profile_photo),
                contentDescription = stringResource(id = R.string.profile_pic)
            )

            Text(
                text = stringResource(id = R.string.my_name),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(text = stringResource(id = R.string.role), fontSize = 20.sp)
        }

        Column(
            modifier = modifier
                .weight(3f)
                .background(
                    shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                    color = Color.Blue
                )
                .padding(8.dp)
        ) {
            Text(text = stringResource(id = R.string.about_me), maxLines = 4, fontSize = 18.sp)
            Spacer(modifier = modifier.height(10.dp))
            Text(text = stringResource(id = R.string.skills), fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Row(modifier.fillMaxWidth()) {
                SkillsRow(
                    painter = painterResource(id = R.drawable.kotlin_logo),
                    contentDescription = stringResource(id = R.string.kt_logo),
                    label = stringResource(id = R.string.kt))
                

                
            }
        }
    }
}

@Composable
fun SkillsRow(painter: Painter,contentDescription: String, label: String) {

  Column(verticalArrangement = Arrangement.Center) {
    Image(painter = painter, contentDescription = contentDescription)
    Text(text = label, fontSize = 18.sp)
}
    Spacer(modifier = Modifier.width(10.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ResumeDetails()
}