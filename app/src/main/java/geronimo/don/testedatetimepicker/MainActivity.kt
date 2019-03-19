package geronimo.don.testedatetimepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private var year: Int = 0

    private var month: Int = 0

    private var day: Int = 0

    private var hour: Int = 0

    private var minute: Int = 0

    private var seconds: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Criação do calendário com minha timezone
        val currCalendar = Calendar.getInstance()
        currCalendar.timeZone = TimeZone.getTimeZone("America/Sao_Paulo")
        //pega a data atual
        year = currCalendar.get(Calendar.YEAR);
        month = currCalendar.get(Calendar.MONTH);
        day = currCalendar.get(Calendar.DAY_OF_MONTH);
        hour = currCalendar.get(Calendar.HOUR_OF_DAY);
        minute = currCalendar.get(Calendar.MINUTE);
        seconds = currCalendar.get(Calendar.SECOND);
        //configuracao do datepicker
        datePickerExample.init(year, month,day, object:DatePicker.OnDateChangedListener{
            override fun onDateChanged(picker: DatePicker?, year: Int, month: Int, day: Int) {
                Log.d("TESTE", "$year/$month/$day")

            }
        })
        //Configuraçao do timepicker
        timePickerExample.hour = hour
        timePickerExample.minute = minute
        timePickerExample.setOnTimeChangedListener(object:TimePicker.OnTimeChangedListener{
            override fun onTimeChanged(picker: TimePicker?, hora: Int, minuto: Int) {
                Log.d("TESTE", "$hora:$minuto")
            }

        })

    }
}
