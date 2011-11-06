package com.emal.kladr.web;

import java.util.Collection;

import com.emal.kladr.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

@Component("adminApplication")
public class AdminWebApplication extends Application
{
	private static final long serialVersionUID = 1L;
    private static final String ROLE_ADMIN = "ROLE_ADMIN";

    @Autowired
    private AddressService addressService;

	@Override
	public void init()
	{
		Window window;
		Label label;
		Button logout;

		window = new Window("My Vaadin Application");

		setMainWindow(window);
		setLogoutURL("/admin/j_spring_security_logout");

		if (hasAnyRole(ROLE_ADMIN))
		{
			label = new Label("You have admin role.");
		}
		else
		{
			label = new Label("You have user role.");
		}

		logout = new Button("logout");
		logout.addListener(new Button.ClickListener()
		{
            private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event)
			{
				getMainWindow().getApplication().close();
			}
		});

		window.addComponent(label);
		window.addComponent(logout);
	}

	private boolean hasAnyRole(String... roles)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority authority : authorities)
		{
			for (String role : roles)
			{
				if (role.equals(authority.getAuthority()))
				{
					return true;
				}
			}
		}
		return false;
	}
}