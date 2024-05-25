package xyz.artenes.budget.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DevelopmentScreen(
    viewModel: DevelopmentViewModel = hiltViewModel()
) {

    val showSnackBar by viewModel.showSnackBar.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = remember {
        SnackbarHostState()
    }

    LaunchedEffect(key1 = showSnackBar) {
        showSnackBar.consume {
            coroutineScope.launch {
                snackBarHostState.showSnackbar(it)
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        topBar = {
            TopAppBar(title = { Text(text = "Development tools") })
        }
    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .padding(30.dp)
        ) {

            //Add buttons

        }

    }

}