/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medical_Previous;

import java.util.ArrayList;

/**
 *
 * @author herrerach_sd2022
 */
public class Storage {

    private ArrayList<Medicine> Storage = new ArrayList<Medicine>();

    public Storage() {
    }

    public ArrayList<Medicine> getStorage() {
        return Storage;
    }

    public void setStorage(ArrayList<Medicine> Storage) {
        this.Storage = Storage;
    }
    
    public void MedStorage(Medicine med){
        Storage.add(med);
    }
}
