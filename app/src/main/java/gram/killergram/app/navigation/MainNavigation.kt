package gram.killergram.app.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

internal fun NavGraphBuilder.main() {
    navigation(
        route = NavigationRoute.Main.route,
        startDestination = NavigationRoute.Root.route,
    ) {

    }
}
