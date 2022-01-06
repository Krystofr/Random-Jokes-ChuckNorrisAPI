package app.christopher.chucknorrisjokes.view

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import app.christopher.chucknorrisjokes.MainActivity
import app.christopher.chucknorrisjokes.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ChuckNavigationTest {

    @Test
    fun testChuckFragmentsNavigation() {
        //Setup
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //Navigate to SearchFragment
        onView(withId(R.id.btn_search)).perform(click())
        //Verify
        onView(withId(R.id.fragment_search)).check(matches(isDisplayed()))

        //Navigate to  CategoriesFragment
        onView(withId(R.id.btn_categories)).perform(click())
        //Verify
        onView(withId(R.id.fragment_categories)).check(matches(isDisplayed()))

        //In case we want to navigate back
        //pressBack()
        //Verify
        //onView(withId(R.id.fragment_home)).check(matches(isDisplayed()))
    }
}