package com.tutorialjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutorialjetpackcompose.ui.model.people
import com.tutorialjetpackcompose.ui.theme.JetPackComposeTheme

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tutorialjetpackcompose.screens.Profile

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetPackComposeTheme {
                MainCard()
            }
        }
    }

    val listPeople = listOf(
        people(
            name = "JUAN",
            lastActivity = "3 minutes ago",
            iconId = R.drawable.rana_rene,
            postId = R.drawable.canada
        ),
        people(
            name = "CARLITA",
            lastActivity = "1 minutes ago",
            iconId = R.drawable.rana_rene,
            postId = R.drawable.amsterdam
        ),
        people(
            name = "PEDRO",
            lastActivity = "2 minutes ago",
            iconId = R.drawable.rana_rene,
            postId = R.drawable.tokio
        ),
        people(
            name = "MARIA",
            lastActivity = "5 minutes ago",
            iconId = R.drawable.rana_rene,
            postId = R.drawable.costarica
        ),
        people(
            name = "PABLO",
            lastActivity = "10 minutes ago",
            iconId = R.drawable.rana_rene,
            postId = R.drawable.estocolmo
        ),
        people(
            name = "ANDRES",
            lastActivity = "18 minutes ago",
            iconId = R.drawable.rana_rene,
            postId = R.drawable.melbourne
        ),
        people(
            name = "CHARLY",
            lastActivity = "20 minutes ago",
            iconId = R.drawable.rana_rene,
            postId = R.drawable.paris
        ),
        people(
            name = "ANTONELLA",
            lastActivity = "60 minutes ago",
            iconId = R.drawable.rana_rene,
            postId = R.drawable.shangai
        ),
        people(
            name = "JHON",
            lastActivity = "0 minutes ago",
            iconId = R.drawable.rana_rene,
            postId = R.drawable.moscu
        ),
        people(
            name = "ANDREA",
            lastActivity = "22 minutes ago",
            iconId = R.drawable.rana_rene,
            postId = R.drawable.argentina
        ),
    )

    @Composable
    fun MainCard() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Routes.Profile.route) {
            composable(Routes.Profile.route) {

                composable(Routes.Profile.route) {
                    //Profile Screen
                    Profile("hola")
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxSize()
        )
        {
            LazyColumn {
                itemsIndexed(
                    items = listPeople
                ) {

                    index, recipe ->
                    BodyCard(people = recipe, onClick = {
                        Toast.makeText(this@MainActivity, recipe.name, Toast.LENGTH_LONG).show()

                    })
                }

            }
        }
    }

    @Composable
    fun AvatarCard(people: people) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = people.iconId),
                contentDescription = "Avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
//                    .width(100.dp)
//                    .height(100.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(200.dp))
            )
            Column {
                Text(text = people.name, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Text(text = people.lastActivity)
            }
        }
    }

    @Composable
    fun BodyCard(
        people: people,
        onClick: () -> Unit = { }
    ) {
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Card(elevation = 4.dp, modifier = Modifier.clickable(onClick = onClick)) {
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth()
                ) {
                    AvatarCard(people)
                    Spacer(Modifier.size(16.dp))
                    Image(
                        painter = painterResource(id = people.postId),
                        contentDescription = "Avatar",
                        modifier = Modifier.width(1000.dp)
                    )
                }
            }
        }
    }


}



