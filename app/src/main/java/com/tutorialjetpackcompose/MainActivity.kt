package com.tutorialjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutorialjetpackcompose.ui.theme.JetPackComposeTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.kermit)
            val description = "Kermit in the snow"
            val title = "kermit is playing in the snow"
            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp)){
                ImageCard(painter = painter, contentDescription = description, title = title)
            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription:String,
    title:String,
    modifer:Modifier=Modifier
) {
    Card(
        modifier = modifer.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                ))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Row() {
                    Text(title,style = TextStyle(color = Color.White,fontSize = 16.sp))

                }

            }
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(100.dp),
//                contentAlignment = Alignment.TopStart
//            ) {
//                Text("Trol",style = TextStyle(color = Color.White,fontSize = 16.sp))
//            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ImageCardPreview() {
    val painter = painterResource(id = R.drawable.kermit)
    val description = "snowasdasdasdasd"
    val title = "kermit is playing in the snow"
    Box(modifier = Modifier
        .fillMaxWidth(0.5f)
        .padding(16.dp)){
        ImageCard(painter = painter, contentDescription = description, title = title)
    }
}