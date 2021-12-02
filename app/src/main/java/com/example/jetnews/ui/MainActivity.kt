/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetnews.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Upload
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.ui.core.dp
import androidx.ui.layout.Padding
import com.example.jetnews.Drawer
import com.example.jetnews.DrawerScreens
import com.example.jetnews.utils.NavigationDrawerTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTheme {
                AppMainScreen()
            }
        }

    }
}



@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun AppMainScreen() {
    val navController = rememberNavController()
    val result = remember { mutableStateOf("") }
    val selectedItem = remember { mutableStateOf("download")}

    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = {


                BottomAppBar (content = {
                    BottomNavigation() {
                        BottomNavigationItem(
                            icon = {
                                Icon(Icons.Filled.Favorite, "")
                            },
                            label = { Text(text = "Favorite",maxLines = 1,overflow = TextOverflow.Ellipsis) },
                            selected = selectedItem.value == "favorite",
                            onClick = {
                                result.value = "Favorite icon clicked"
                                selectedItem.value = "favorite"
                            },
                            alwaysShowLabel = false
                        )

                        BottomNavigationItem(
                            icon = {
                                Icon(Icons.Filled.Save, "")
                            },
                            label = { Text(text = "Save",maxLines = 1,overflow = TextOverflow.Ellipsis) },
                            selected = selectedItem.value == "save",
                            onClick = {
                                result.value = "Save icon clicked"
                                selectedItem.value = "save"
                            },
                            alwaysShowLabel = false
                        )

                        BottomNavigationItem(
                            icon = {
                                Icon(Icons.Filled.Upload, "")
                            },
                            label = { Text(text = "Upload",maxLines = 1,overflow = TextOverflow.Ellipsis) },
                            selected = selectedItem.value == "upload",
                            onClick = {
                                result.value = "Upload icon clicked"
                                selectedItem.value = "upload"
                            },
                            alwaysShowLabel = false
                        )

                        BottomNavigationItem(
                            icon = {
                                Icon(Icons.Filled.Download, "")
                            },
                            label = { Text(text = "Download",maxLines = 1,overflow = TextOverflow.Ellipsis) },
                            selected = selectedItem.value == "download",
                            onClick = {
                                result.value = "Download icon clicked"
                                selectedItem.value = "download"
                            },
                            alwaysShowLabel = false
                        )

                    }
                })

        },

    ) {
            innerPadding->
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val openDrawer = {
            scope.launch {
                drawerState.open()
            }
        }

        Column(
            Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding()),
        ) {

            ModalDrawer(
                drawerState = drawerState,
                gesturesEnabled = drawerState.isOpen,
                drawerContent = {
                    Drawer(
                        onDestinationClicked = { route ->
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(route) {
                                popUpTo = navController.graph.startDestinationId
                                launchSingleTop = true
                            }
                        }
                    )
                },
            ) {

                var screenName = ""
                if(selectedItem.value == "save"){
                    screenName = DrawerScreens.Account.route
                }else  if(selectedItem.value == "upload"){
                    screenName = DrawerScreens.Help.route
                }else  if(selectedItem.value == "download"){
                    screenName = DrawerScreens.Download.route
                }else{
                    screenName = DrawerScreens.Home.route
                }

                NavHost(
                    navController = navController,
                    startDestination = screenName
                ) {
                    composable(DrawerScreens.Home.route) {
                        Home(
                            openDrawer = {
                                openDrawer()
                            }
                        )
                    }
                    composable(DrawerScreens.Account.route) {
                        Account(
                            openDrawer = {
                                openDrawer()
                            }
                        )
                    }
                    composable(DrawerScreens.Help.route) {
                        BottomSheetSample(
                            navController = navController
                        )
                    }
                    composable(DrawerScreens.Download.route) {
                        Download(
                            openDrawer = {
                                openDrawer()
                            }
                        )

                    }
                }
            }
        }
    }


}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationDrawerTheme {
        AppMainScreen()
    }
}

/*
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.jetnews.JetnewsApplication
import com.example.jetnews.utils.rememberWindowSizeClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val appContainer = (application as JetnewsApplication).container
        setContent {
            val windowSizeClass = rememberWindowSizeClass()
            JetnewsApp(appContainer, windowSizeClass)
        }
    }
}*/
