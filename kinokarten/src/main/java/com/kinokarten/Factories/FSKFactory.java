package com.kinokarten.Factories;

import com.kinokarten.Objects.FSK;
/**
 * Erstellt die alters Beschränkungen und definiert sie 
 */
public class FSKFactory {
    public static FSK Create(int fskZahl){
        FSK ergebnisFSK = FSK.Ü0;
        if (fskZahl > 18) {
            ergebnisFSK = FSK.Ü18;
        } else if(fskZahl > 16){
            ergebnisFSK = FSK.Ü16;
        }
        else if(fskZahl > 12){
            ergebnisFSK = FSK.Ü12;
        }
        else if(fskZahl > 6){
            ergebnisFSK = FSK.Ü6;
        }
        return ergebnisFSK;
    }
}
