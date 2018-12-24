package com.wissensalt.tgf.web.vaadin.component.button.menu;

import com.vaadin.server.FileResource;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.MenuBar;
import com.wissensalt.tgf.web.vaadin.command.LogOutCommand;
import com.wissensalt.tgf.web.vaadin.constant.TGFValoTheme;
import com.wissensalt.tgf.web.vaadin.ui.StringGenerator;
import com.wissensalt.tgf.web.vaadin.util.IComponentInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * Created on 9/14/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
@Scope(scopeName = "singleton")
public class MenuUserSetting extends MenuBar implements IComponentInitializer{
    /**
     *
     *
     */
    private static final long serialVersionUID = -8878541442598640228L;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private LogOutCommand logOutCommand;

    @Value("${app.default.profile.picture}")
    private String appDefaultProfilePicture;

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuUserSetting.class);

    @PostConstruct
    @Override
    public void initComponents() {
        this.addStyleName(TGFValoTheme.USER_MENU);
        StringGenerator sg = new StringGenerator();
        File fileImg = null;
        try {
            fileImg = resourceLoader.getResource("classpath:"+appDefaultProfilePicture).getFile();
        } catch (IOException e) {
            LOGGER.error(e.toString());
        }
        assert fileImg != null;
        MenuBar.MenuItem settingsItem = this.addItem(
                sg.nextString(true).concat(" ").concat(sg.nextString(true)).concat(sg.nextString(false)),
                new FileResource(fileImg),
                null
        );
        settingsItem.addItem("Edit Profile", null);
        settingsItem.addItem("Preferences", null);
        settingsItem.addSeparator();
        settingsItem.addItem("Sign Out", logOutCommand);
    }

}
