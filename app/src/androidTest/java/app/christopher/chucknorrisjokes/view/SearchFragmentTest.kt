package app.christopher.chucknorrisjokes.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import app.christopher.chucknorrisjokes.R
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SearchFragmentTest {

    @Test
    fun testSearchTextInput() {
        onView(withId(R.id.et_query)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.et_query)).perform(typeText("Hey Chuck"))
    }
}