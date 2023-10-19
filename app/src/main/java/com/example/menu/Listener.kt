import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.menu.MainActivity
import com.example.menu.R
import kotlin.random.Random

class Listener(var activity: MainActivity) : View.OnClickListener {


    fun count(x: Array<Int>): Int{
        return x.sum()
    }
    fun getDishName(dish: Array<Array<String>>, important: Array<Array<Int>>, i: Int): String{
        var x = Random.nextInt(0, count(important[i]) + 1)
        var cnt = 0
        for(j in 0 until important[i].size){
            cnt += important[i][j]
            if(x <= cnt){
                Log.d("view", "x: ${x} \n i: ${i} \n count: ${count(important[i])}")
                return dish[i][j]
            }
        }
        return ""
    }
    override fun onClick(view: View) {
        // Xử lý click button
        if (view is Button){
            var view = view as Button
            view.setBackgroundColor(Color.RED)
        }
        var menu1:TextView = activity.findViewById(R.id.menu1)
        var menu2:TextView = activity.findViewById(R.id.menu2)
        var menu3:TextView = activity.findViewById(R.id.menu3)

        var dish = activity.x.dish
        var important = activity.x.important

        menu1.text = getDishName(dish, important, 0)
        menu2.text = getDishName(dish, important, 1)
        menu3.text = getDishName(dish, important, 2)
    }

    fun onTextChanged(text: String) {
        // Xử lý text thay đổi
    }

    fun onItemClick(position: Int) {
        // Xử lý click item trong RecyclerView
    }

    // Các listener khác
}