package org.hse.project2;

import android.text.InputFilter;
import android.text.Spanned;

public class InputFilterMaxMin implements InputFilter {
    private int min, max;

    public InputFilterMaxMin(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public CharSequence filter(CharSequence charSequence, int i, int i1, Spanned spanned,
                               int i2, int i3) {
        int input = Integer.parseInt(spanned.toString() + charSequence.toString());

        if (input >= min && input <= max) {
            return null;
        } else {
            return "";
        }
    }
}
