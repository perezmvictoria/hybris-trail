
package de.hybris.platform.cuppytrailfrontend.controller;

import de.hybris.platform.cuppytrail.data.StadiumData;
import de.hybris.platform.cuppytrail.facades.StadiumFacade;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
public class StadiumsController
{
	@Resource
	private StadiumFacade defaultStadiumFacade;

	@RequestMapping(value = "/stadiums")
	public String showStadiums(final Model model)
	{
		final List<StadiumData> stadiums = defaultStadiumFacade.getStadiums("stadiumListFormat");
		model.addAttribute("stadiums", stadiums);
		return "StadiumListing";
	}

	@RequestMapping(value = "/stadiums/{stadiumName}")
	public String showStadiumDetails(@PathVariable String stadiumName, final Model model) throws UnsupportedEncodingException
	{
		stadiumName = URLDecoder.decode(stadiumName, "UTF-8");
		final StadiumData stadium = defaultStadiumFacade.getStadium(stadiumName, "stadiumDetailsFormat");
		stadium.setName(stadium.getName());//StadiumsNameEncoded.getNameEncoded(stadium.getName()));
		model.addAttribute("stadium", stadium);
		return "StadiumDetails";
	}

}
