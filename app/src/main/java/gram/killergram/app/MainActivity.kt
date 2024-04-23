package gram.killergram.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import gram.killergram.app.navigation.KillergramApp
import gram.killergram.core.designsystem.ui.theme.KillergramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KillergramTheme {
                KillergramApp()
            }
        }
    }
}
