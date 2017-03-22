/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.dao;

import java.util.List;
import np.com.drose.studentmanagementsystem.model.Progress;

/**
 *
 * @author bibekshakya
 */
public interface ProgressDao {
    public int insertProgress(Progress progress);
    public List<Progress> getProgressList();
}
