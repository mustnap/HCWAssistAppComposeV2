package my.bloo.hcwassistappcomposev2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import my.bloo.hcwassistappcomposev2.ui.theme.HCWAssistAppComposeV2Theme
import my.bloo.hcwassistappcomposev2.graphs.RootNavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HCWAssistAppComposeV2Theme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HCWAssistAppComposeV2Theme {
        Greeting("Android")
    }
}