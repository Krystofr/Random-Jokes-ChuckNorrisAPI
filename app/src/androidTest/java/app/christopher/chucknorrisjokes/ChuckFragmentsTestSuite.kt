package app.christopher.chucknorrisjokes

import app.christopher.chucknorrisjokes.view.ChuckNavigationTest
import app.christopher.chucknorrisjokes.view.SearchFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    ChuckNavigationTest::class,
    MainActivityTest::class,
    SearchFragmentTest::class
)
class ChuckFragmentsTestSuite