package app.christopher.chucknorrisjokes

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    val activityScenario = ActivityScenario.launch(MainActivity::class.java)

    //Test activity launch
    @Test
    fun is_activityInView() {
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
}