package co.id.myselfapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab: View = findViewById(R.id.fab_daily)
        fab.setOnClickListener { view ->
            startActivity(Intent(this@MainActivity, DailyActivity::class.java))
        }
        bottomNavigationView = findViewById<View>(R.id.bottomnavigationbar) as BottomNavigationView
        bottomNavigationView!!.background = null
        bottomNavigationView!!.menu.getItem(2).isEnabled = false
        supportFragmentManager.beginTransaction().replace(R.id.framecontainer, HomeFragment())
            .commit()
        bottomNavigationView!!.setOnNavigationItemSelectedListener { item ->
            var temp: Fragment? = null
            when (item.itemId) {
                R.id.mHome -> temp = HomeFragment()
                R.id.mGallery -> temp = GalleryFragment()
                R.id.mPerson -> temp = MusicFragment()
                R.id.mSetting -> temp = ProfileFragment()
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.framecontainer,
                temp!!
            ).commit()
            true
        }
    }
}