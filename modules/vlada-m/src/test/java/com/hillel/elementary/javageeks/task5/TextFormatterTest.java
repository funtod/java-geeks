package com.hillel.elementary.javageeks.task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextFormatterTest {

    @Test
    void shouldFormatText() {
        String text = "One night—it was on the 20th of March, 1888—I was returning from a journey to a patient (for I had now returned to civil practice), when my way led me through Baker Street. As I passed the well-remembered door, which must always be associated in my mind with my wooing, and with the dark incidents of the Study in Scarlet, I was seized with a keen desire to see Holmes again, and to know how he was employing his extraordinary powers.";
   String formatted = TextFormatter.format(text);
   String expectedResult = "One Night—It Was On The 20th Of March, 1888—I Was Returning From A Journey To A Patient (For I Had Now Returned To Civil Practice), When My Way Led Me Through Baker Street. As I Passed The well-remembered Door, Which Must Always Be Associated In My Mind With My Wooing, And With The Dark Incidents Of The Study In Scarlet, I Was Seized With A Keen Desire To See Holmes Again, And To Know How He Was Employing His Extraordinary Powers.";
   assertEquals(expectedResult, formatted);
    }
}