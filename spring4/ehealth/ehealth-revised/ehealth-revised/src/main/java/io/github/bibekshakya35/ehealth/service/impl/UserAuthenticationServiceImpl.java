package io.github.bibekshakya35.ehealth.service.impl;

import io.github.bibekshakya35.ehealth.DAO.genericdao.IGenericDao;
import io.github.bibekshakya35.ehealth.exception.EhealthException;
import io.github.bibekshakya35.ehealth.exception.config.AppMessageType;
import io.github.bibekshakya35.ehealth.model.User;
import io.github.bibekshakya35.ehealth.security.APISecurityDetail;
import io.github.bibekshakya35.ehealth.service.UserAuthenticationService;
import io.github.bibekshakya35.ehealth.utils.SecurityUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * {Insert class description here}
 *
 * @author bibek
 */
@Service
class UserAuthenticationServiceImpl implements UserAuthenticationService {
    
    @Autowired
    private final IGenericDao<User> iGenericDao;
    
    @Autowired
    public UserAuthenticationServiceImpl(IGenericDao<User> iGenericDao) {
        this.iGenericDao = iGenericDao;
        this.iGenericDao.setClazz(User.class);
    }
    
    private static final Logger LOG = Logger.getLogger(UserAuthenticationServiceImpl.class.getName());
    
    
    @Transactional(readOnly = true)
    @Override
    public String authenticateUser(String username, String password) {
        LOG.log(Level.INFO, "Inside of the user authentication{0}", username);
        User user = this.iGenericDao.findOne(username);
        if (user == null) {
            throw new EhealthException(AppMessageType.USER_INVALID_CREDENTIAL);
        }
        if (!SecurityUtils.isEqualEncoding(user.getUserPassword(), password)) {
            throw new EhealthException(AppMessageType.SESSION_EXPIRED);
        }
        return SecurityUtils.generateToken(new APISecurityDetail(username, user.getUserKey()));
    }
    
}
