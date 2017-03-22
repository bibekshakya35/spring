/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.drose.studentmanagementsystem.services.impl;

import java.util.List;
import javax.transaction.Transactional;
import np.com.drose.studentmanagementsystem.dao.ProgressDao;
import np.com.drose.studentmanagementsystem.model.Progress;
import np.com.drose.studentmanagementsystem.services.ProgressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bibekshakya
 */
@Transactional
@Service
public class ProgressServicesImpl implements ProgressServices{
    @Autowired
    ProgressDao progressDao;

    @Override
    public int insertProgress(Progress progress) {
        return progressDao.insertProgress(progress);
    }

    @Override
    public List<Progress> getProgressList() {
        return progressDao.getProgressList();
    }
    
    
    
    
}
