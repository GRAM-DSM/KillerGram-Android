package gram.killergram.app.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

internal fun NavGraphBuilder.auth() {
    navigation(
        route = gram.killergram.app.navigation.NavigationRoute.Auth.route,
        startDestination = gram.killergram.app.navigation.NavigationRoute.Auth.SPLASH,
    ) {

    }
}
