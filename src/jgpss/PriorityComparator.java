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
class PriorityComparator implements Comparator<Xact> {

    public PriorityComparator() {
    }

    public int compare(Xact t, Xact t1) {
        if (t.getPriority() > t1.getPriority()) {
            return -1;
        }
        if (t.getPriority() < t1.getPriority()) {
            return 1;
        }
        return 0;
    }
    
}
