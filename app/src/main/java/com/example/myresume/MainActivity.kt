package com.example.myresume

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.myresume.Constants.GITHUB_LINK
import com.example.myresume.Constants.GMAIL_LINK
import com.example.myresume.Constants.LINKEDIN
import com.example.myresume.Constants.TWITTER
import com.example.myresume.ui.theme.MyResumeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyResumeTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val screenState = remember {
                        MutableTransitionState(false).apply { targetState = true }
                    }
                    AnimatedVisibility(
                        visibleState = screenState,
                        content = { ResumeDetails() },
                        enter = fadeIn(),
                        exit = fadeOut()
                    )
                }
            }
        }
    }
}

@Composable
fun ResumeDetails(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colors.primary)
    ) {

        //first part of the screen (1/2 of the screen)
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .scrollable(scrollState, orientation = Orientation.Horizontal),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            Image(
                modifier = modifier
                    .size(100.dp)
                    .padding(4.dp)
                    .border(
                        BorderStroke(2.dp, MaterialTheme.colors.primaryVariant),
                        CircleShape
                    )
                    .clip(CircleShape),
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

        //Second part of the screen (1/2 of the screen)
        var performIntent by remember { mutableStateOf(false) }
        var actionName by remember { mutableStateOf("") }
        if (performIntent) {
            NavActions(icon = NavIcons.valueOf(actionName))
        }
        Column(
            modifier = modifier
                .weight(2f)
                .background(
                    shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                    color = MaterialTheme.colors.surface
                )
                .padding(8.dp)
                .scrollable(scrollState, Orientation.Horizontal),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = stringResource(id = R.string.about_me), maxLines = 5, fontSize = 15.sp)
            Spacer(modifier = modifier.height(10.dp))
            Text(
                text = stringResource(id = R.string.skills),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                SkillsRow(
                    painter = painterResource(id = R.drawable.kotlin_log),
                    contentDescription = stringResource(id = R.string.kt_logo),
                    label = stringResource(id = R.string.kt)
                )

                SkillsRow(
                    painter = painterResource(id = R.drawable.java_logo),
                    contentDescription = stringResource(id = R.string.java_logo),
                    label = stringResource(id = R.string.jv)
                )

                SkillsRow(
                    painter = painterResource(id = R.drawable.python_logo),
                    contentDescription = stringResource(id = R.string.py_logo),
                    label = stringResource(id = R.string.py)
                )

                SkillsRow(
                    painter = painterResource(id = R.drawable.matlab_logo),
                    contentDescription = stringResource(id = R.string.mat_logo),
                    label = stringResource(id = R.string.mat)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(id = R.string.contact),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(items = NavIcons.values()) { item ->
                    Column(
                        horizontalAlignment = CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = modifier.padding(4.dp)
                    ) {

                        Image(
                            painter = painterResource(id = item.iconId),
                            contentDescription = item.name,
                            modifier = modifier
                                .size(60.dp)
                                .clickable {
                                    actionName = item.name
                                    performIntent = !performIntent
                                }
                        )
                        Spacer(modifier = modifier.height(10.dp))
                        Text(text = item.name, fontSize = 20.sp)
                    }
                }
            }
        }
    }
}

//Respective actions/intents to be done
@Composable
fun NavActions(icon: NavIcons) {
    val context = LocalContext.current

    return when (icon) {
        //GitHub
        NavIcons.GitHub -> {
            try {
                val gitIntent = Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_LINK))
                startActivity(context, gitIntent, null)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    context,
                    stringResource(id = R.string.no_app_found),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        //Gmail
        NavIcons.Gmail -> {
            try {
                //no Composable can be used in a try block
                val mailIntent = Intent(Intent.ACTION_SEND)
                val emailAddress = arrayOf(GMAIL_LINK)
                mailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddress)
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Job Application")
                mailIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Hello Joy, I hope this finds you well."
                )
                mailIntent.type = "message/rfc822"
                context.startActivity(
                    Intent.createChooser(
                        mailIntent,
                        "Sending Email from this app"
                    )
                )
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    context,
                    stringResource(id = R.string.no_app_found),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        //LinkedIn
        NavIcons.LinkedIn -> {
            try {
                val linkedIntent = Intent(Intent.ACTION_VIEW, Uri.parse(LINKEDIN))
                startActivity(context, linkedIntent, null)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    context,
                    stringResource(id = R.string.no_app_found),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        //Twitter
        NavIcons.Twitter -> {
            try {
                val twiIntent = Intent(Intent.ACTION_VIEW, Uri.parse(TWITTER))
                startActivity(context, twiIntent, null)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    context,
                    stringResource(id = R.string.no_app_found),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

//To simplify creating Image and Text Creation in Skills section
@Composable
fun SkillsRow(
    painter: Painter,
    contentDescription: String,
    label: String,
    modifier: Modifier = Modifier,
    imageSize: Dp = 60.dp
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = modifier
                .size(imageSize)
                .clip(shape = CircleShape)
        )
        Text(text = label, fontSize = 18.sp)
    }
    Spacer(modifier = modifier.width(10.dp))
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun DefaultPreview() {
    MyResumeTheme {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxWidth()
        ) {
            ResumeDetails()
        }
    }
}
