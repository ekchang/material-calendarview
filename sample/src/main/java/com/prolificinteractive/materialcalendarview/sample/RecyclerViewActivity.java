package com.prolificinteractive.materialcalendarview.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import java.util.Calendar;
import java.util.Date;

public class RecyclerViewActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recycler_view);
    RecyclerView rv = (RecyclerView) findViewById(android.R.id.list);
    rv.setLayoutManager(new LinearLayoutManager(this));
    rv.setAdapter(new RecyclerView.Adapter() {
      @Override
      public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CalendarViewHolder(inflater.inflate(R.layout.item_calendar, parent, false));
      }

      @Override
      public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //disable swipe
        MaterialCalendarView materialCalendarView = ((CalendarViewHolder) holder).mcv;
        materialCalendarView.setPagingEnabled(false);

        //set date
        materialCalendarView.setSelectedDate(CalendarDay.today());
        materialCalendarView.setCurrentDate(CalendarDay.today());

        //setup weekly view
        materialCalendarView.setCalendarDisplayMode(CalendarMode.WEEKS);
        materialCalendarView.setFirstDayOfWeek(Calendar.WEDNESDAY);

        //hide arrows
        materialCalendarView.setLeftArrowMask(null);
        materialCalendarView.setRightArrowMask(null);

        //max min date range
        materialCalendarView.setMinimumDate(CalendarDay.today());
      }

      @Override
      public int getItemCount() {
        return 10;
      }
    });
  }

  static class CalendarViewHolder extends RecyclerView.ViewHolder {
    MaterialCalendarView mcv;
    public CalendarViewHolder(View itemView) {
      super(itemView);
      mcv = (MaterialCalendarView) itemView.findViewById(R.id.calendarView);
    }
  }
}
