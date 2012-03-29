/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgpss;

import java.util.Comparator;

/**
 *
 * @author dgll
 */
class TimeComparator implements Comparator<Xact> {

    public TimeComparator() {
    }

    public int compare(Xact t, Xact t1) {
        if (t.getMoveTime() < t1.getMoveTime()) {
            return -1;
        }
        if (t.getMoveTime() > t1.getMoveTime()) {
            return 1;
        }
        return 0;
    }
    
}
