/**
   Copyright: 2011 Android Aalto

   This file is part of BookingRoom.

   BookingRoom is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 3 of the License, or
   (at your option) any later version.

   BookingRoom is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with BookingRoom. If not, see <http://www.gnu.org/licenses/>.
 */

package org.androidaalto.bookingroom.logic;

import android.text.format.Time;

/**
 * @author hannu
 */
public class MeetingInfo {
    private final Integer id;
    private final UserInfo user;
    private final Time start;
    private final Time end;
    private final String title;
    private int startDay;
    private int endDay;
    private int startMinutesSinceMidnight;
    private int endMinutesSinceMidnight;

    public MeetingInfo(UserInfo user, Time start, Time end, String title) {
        this(null, user, start, end, title);
    }

    public MeetingInfo(Integer id, UserInfo user, Time start, Time end, String title) {
        this.id = id;
        this.user = user;
        this.start = start;
        this.end = end;
        this.title = title;

        startDay = Time.getJulianDay(start.normalize(true), start.gmtoff);
        startMinutesSinceMidnight = start.hour * 60 + start.minute;
        endDay = Time.getJulianDay(end.normalize(true), end.gmtoff);
        endMinutesSinceMidnight = end.hour * 60 + end.minute;
    }

    public Integer getId() {
        return id;
    }

    public UserInfo getUser() {
        return user;
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }

    public String getTitle() {
        return title;
    }

    /**
     * @return the start Julian day
     */
    public int getStartDay() {
        return startDay;
    }

    /**
     * @return the end Julian day
     */
    public int getEndDay() {
        return endDay;
    }

    /**
     * @return the minutes since midnight till the start time
     */
    public int getStartMinutesSinceMidnight() {
        return startMinutesSinceMidnight;
    }

    /**
     * @return the minutes since midnight till the end time
     */
    public int getEndMinutesSinceMidnight() {
        return endMinutesSinceMidnight;
    }

    @Override
    public String toString() {
        return "MeetingInfo [id=" + id + ", start=" + start.format3339(false) + ", end="
                + end.format3339(false) + ", title=" + title
                + "]";
    }
}
