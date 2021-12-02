package com.example.jetnews.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.jetnews.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalFoundationApi
@Composable
fun Home(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Home",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(Modifier.height(10.dp))
            Text(text = "Home Page content here.", modifier = Modifier.padding(start = 10.dp))
            Spacer(Modifier.height(10.dp))
            Divider()
            Spacer(Modifier.height(10.dp))
            val myData = listOf(
                "Hello,",
                "world!",
                "This",
                "is",
                "Mansi",
                "Bhatt",
                "Hello,",
                "world!",
                "This",
                "is",
                "Mansi",
                "Bhatt",
                "Hello,",
                "world!",
                "This",
                "is",
                "Mansi",
                "Bhatt",
                "Hello,",
                "world!",
                "This",
                "is",
                "Mansi",
                "Bhatt",
                "Hello,",
                "world!",
                "This",
                "is",
                "Mansi",
                "Bhatt",
                "Hello,",
                "world!",
                "This",
                "is",
                "Mansi",
                "Bhatt",
            )
            /* LazyColumn {
                 itemsIndexed(myData) { index, item ->

                     Card(
                         shape = RoundedCornerShape(8.dp),
                         modifier = Modifier
                             .padding(10.dp)
                             .fillMaxWidth(),
                         elevation = 3.dp
                     ) {
                         Box(modifier = Modifier
                             .height(90.dp)
                             .padding(10.dp)) {
                            Column() {
                                Image(
                                    painterResource(R.drawable.post_2_thumb),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.height(50.dp).fillMaxWidth()
                                )
                                Text(text = "Item #$index ",modifier = Modifier.padding(start = 10.dp)
                                    .align(alignment = Alignment.CenterHorizontally))

                            }
                         }
                     }

                 }
             }*/
            LazyVerticalGrid(
                cells = GridCells.Fixed(2)
            ) {
                items(myData.size) {
                    Card(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth(),
                        elevation = 4.dp
                    ) {
                        Box(
                            modifier = Modifier
                                .height(85.dp)
                        ) {
                            Column() {
                                Image(
                                    painterResource(R.drawable.post_2_thumb),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .height(60.dp)
                                        .fillMaxWidth()
                                        .clip(
                                            RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp)
                                        )
                                )
                                Text(
                                    text = "Item #$it", modifier = Modifier
                                        .padding(start = 10.dp)
                                        .align(alignment = Alignment.CenterHorizontally)
                                )

                            }
                        }
                    }
                }
            }
        }

    }
}


@Composable
fun Download(openDrawer: () -> Unit) {

    var (showialog, setShowDialog) = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Home",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(Modifier.height(10.dp))
            Text(text = "Home Page content here.", modifier = Modifier.padding(start = 10.dp))
            Spacer(Modifier.height(10.dp))
            Divider()
            Spacer(Modifier.height(10.dp))
            val myData = listOf(
                "Hello,",
                "world!",
                "This",
                "is",
                "Mansi",
                "Bhatt",
                "Hello,",
                "world!",
                "This",
                "is",
                "Mansi",
                "Bhatt",
                "Hello,",
                "world!",
                "This",
                "is",
                "Mansi",
                "Bhatt",
                "Hello,",
                "world!",
                "This",
                "is",
                "Mansi",
                "Bhatt",
                "Hello,",
                "world!",
                "This",
                "is",
                "Mansi",
                "Bhatt",
                "Hello,",
                "world!",
                "This",
                "is",
                "Mansi",
                "Bhatt",
            )
            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor: Color by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
            )
            LazyColumn {
                itemsIndexed(myData) { index, item ->

                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .animateContentSize()
                            .padding(10.dp)
                            .fillMaxWidth(),
                        elevation = 3.dp,
                        contentColor = surfaceColor
                    ) {

                        Box(modifier = Modifier
                            .height(90.dp)
                            .padding(10.dp)
                            .clickable {
                                //setShowDialog(true)
                                isExpanded = !isExpanded
                                // surfaceColor will be updated gradually from one color to the other

                            }
                        ) {
                            Column() {
                                Image(
                                    painterResource(R.drawable.post_2_thumb),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .height(50.dp)
                                        .fillMaxWidth()

                                )
                                Text(
                                    text = "Item #$index ", modifier = Modifier
                                        .padding(start = 10.dp)
                                        .align(alignment = Alignment.CenterHorizontally)
                                )

                            }
                        }
                    }

                }
            }


            AppDialog(modifier = Modifier
                .width(300.dp)
                .height(220.dp)
                .padding(0.dp)
                .background(color = Color.Transparent),
                dialogState = showialog, onDialogStateChange = {
                    setShowDialog(false)
                })

        }


    }
}

@Composable
fun Account(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Account",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start

        ) {
            Spacer(Modifier.height(10.dp))
            Text(text = "Post 1.", style = MaterialTheme.typography.body2)
            Spacer(Modifier.height(5.dp))
            Image(
                painterResource(R.drawable.post_1),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Spacer(Modifier.height(5.dp))
            Text(text = "Post 2.", style = MaterialTheme.typography.body2)
            Spacer(Modifier.height(5.dp))
            Image(
                painterResource(R.drawable.post_2),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Spacer(Modifier.height(5.dp))

            Text(text = "Post 3.", style = MaterialTheme.typography.body2)
            Spacer(Modifier.height(5.dp))
            Image(
                painterResource(R.drawable.post_3),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Spacer(Modifier.height(5.dp))
            Text(text = "Post 4.", style = MaterialTheme.typography.body2)
            Spacer(Modifier.height(5.dp))
            Image(
                painterResource(R.drawable.post_4),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Spacer(Modifier.height(5.dp))
            Text(text = "Post 5.", style = MaterialTheme.typography.body2)
            Spacer(Modifier.height(5.dp))
            Image(
                painterResource(R.drawable.post_5),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Spacer(Modifier.height(10.dp))


        }
    }
}
/*
@Composable
fun VerticalScroller(
scrollerPosition: ScrollerPosition = ScrollerPosition(),
modifier: Modifier = Modifier,
isScrollable: Boolean = true,
children: @Composable ColumnScope.() -> Unit
) {
}*/

@Composable
fun Help(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Help",
            buttonIcon = Icons.Filled.ArrowBack,
            onButtonClicked = { navController.popBackStack() }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Help.", style = MaterialTheme.typography.h4)

        }
    }
}

@Composable
fun TopBar(title: String = "", buttonIcon: ImageVector, onButtonClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = title
            )
        },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() }) {
                Icon(buttonIcon, contentDescription = "")
            }
        },
        backgroundColor = MaterialTheme.colors.primaryVariant
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AppDialog(
    modifier: Modifier = Modifier,
    dialogState: Boolean = false,
    onDialogPositiveButtonClicked: (() -> Unit)? = null,
    onDialogStateChange: ((Boolean) -> Unit)? = null,
    onDismissRequest: (() -> Unit)? = null,
) {
    val textPaddingAll = 24.dp
    val buttonPaddingAll = 8.dp
    val dialogShape = RoundedCornerShape(16.dp)

    if (dialogState) {
        AlertDialog(
            onDismissRequest = {
                onDialogStateChange?.invoke(false)
                onDismissRequest?.invoke()
            },
            title = null,
            text = null,
            buttons = {

                Column(
                    Modifier.background(color = Color.Cyan),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.post_2),
                        contentDescription = "",

                        )
                    Row(Modifier.padding(all = textPaddingAll)) {
                        Text(
                            text = "Hello"
                        )
                    }
                    Divider(color = MaterialTheme.colors.onSurface, thickness = 1.dp)

                    Row(
                        modifier = Modifier.padding(all = buttonPaddingAll),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        TextButton(

                            onClick = {

                                onDialogStateChange?.invoke(false)
                                onDialogPositiveButtonClicked?.invoke()
                            }
                        ) {
                            Text(
                                text = "Ok",
                                color = MaterialTheme.colors.onSurface,
                            )
                        }
                    }
                }

            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = false, usePlatformDefaultWidth = false
            ),
            modifier = modifier,
            shape = dialogShape
        )
        /*   AlertDialog(
               onDismissRequest = {
                   // Dismiss the dialog when the user clicks outside the dialog or on the back
                   // button. If you want to disable that functionality, simply use an empty
                   // onCloseRequest.
                   onDialogStateChange?.invoke(false)
                   onDismissRequest?.invoke()
               },
               title = {
                   Text(text = "Dialog Title")
               },
               text = {
                   Text("Here is a text ")
               },
               confirmButton = {
                   Button(

                       onClick = {
                           onDialogStateChange?.invoke(false)
                           onDismissRequest?.invoke()
                       }) {
                       Text("This is the Confirm Button")
                   }
               },
               dismissButton = {
                   Button(

                       onClick = {
                           onDialogStateChange?.invoke(false)
                           onDismissRequest?.invoke()
                       }) {
                       Text("This is the dismiss Button")
                   }
               }
           )*/
    }

}

@ExperimentalMaterialApi
@Composable
fun BottomSheetSample(navController: NavController) {

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Help",
            buttonIcon = Icons.Filled.ArrowBack,
            onButtonClicked = { navController.popBackStack() }
        )
        BottomSheetScaffold(
            scaffoldState = bottomSheetScaffoldState,

            sheetContent = {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(Color(0xAA3fa7cc))
                ) {
                    Text(
                        text = "Hello from bottom sheet",
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            },
            sheetPeekHeight = 40.dp
        ) {
            MainscreenView(scope, bottomSheetScaffoldState)
        }
    }
}

@Composable
@ExperimentalMaterialApi
fun MainscreenView(scope: CoroutineScope, bottomSheetScaffoldState: BottomSheetScaffoldState) {
    Box(
        Modifier
            .fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .padding(20.dp)
                .align(alignment = Alignment.TopCenter),
            onClick = {
                scope.launch {
                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    } else {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }
            }
        ) {
            Text(
                text = "Click to show Bottom Sheet"
            )
        }
    }

}

