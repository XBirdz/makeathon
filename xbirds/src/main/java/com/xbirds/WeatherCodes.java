package com.xbirds;
import java.util.HashMap;

public class WeatherCodes {

    public static String getDescr(int code) {

        HashMap<Integer, String> weatherMap = new HashMap<>();
        weatherMap.put(0, "Cloud development not observed or not observable");
        weatherMap.put(1, "Clouds generally dissolving or becoming less developed");
        weatherMap.put(2, "State of sky on the whole unchanged");
        weatherMap.put(3, "Clouds generally forming or developing");
        weatherMap.put(4, "Visibility reduced by smoke, e.g. veldt or forest fires, industrial smoke or volcanic ashes");
        weatherMap.put(5, "Haze");
        weatherMap.put(6, "Widespread dust in suspension in the air, not raised by wind at or near the station at the time of observation");
        weatherMap.put(7, "Dust or sand raised by wind at or near the station at the time of observation, but no well developed dust whirl(s) or sand whirl(s), and no duststorm or sandstorm seen");
        weatherMap.put(8, "Well developed dust whirl(s) or sand whirl(s) seen at or near the station during the preceding hour or at the time ot observation, but no duststorm or sandstorm");
        weatherMap.put(9, "Duststorm or sandstorm within sight at the time of observation, or at the station during the preceding hour");
        weatherMap.put(10, "Mist");
        weatherMap.put(11, "Patches shallow fog or ice fog at the station, whether on land or sea, not deeper than about 2 metres on land or 10 metres at sea");
        weatherMap.put(12, "More or less continuous");
        weatherMap.put(13, "Lightning visible, no thunder heard");
        weatherMap.put(14, "Precipitation within sight, not reaching the ground or the surface of the sea");
        weatherMap.put(15, "Precipitation within sight, reaching the ground or the surface of the sea, but distant, i.e. estimated to be more than 5 km from the station");
        weatherMap.put(16, "Precipitation within sight, reaching the ground or the surface of the sea, near to, but not at the station");
        weatherMap.put(17, "Thunderstorm, but no precipitation at the time of observation");
        weatherMap.put(18, "Squalls at or within sight of the station during the preceding hour or at the time of observation");
        weatherMap.put(19, "Funnel cloud(s) (Tornado cloud or water-spout)");
        weatherMap.put(20, "Drizzle (not freezing) or snow grains not falling as shower(s)");
        weatherMap.put(21, "Rain (not freezing)");
        weatherMap.put(22, "Snow");
        weatherMap.put(23, "Rain and snow or ice pellets");
        weatherMap.put(24, "Freezing drizzle or freezing rain");
        weatherMap.put(25, "Shower(s) of rain");
        weatherMap.put(26, "Shower(s) of snow, or of rain and snow");
        weatherMap.put(27, "Shower(s) of hail, or of rain and hail");
        weatherMap.put(28, "Fog or ice fog");
        weatherMap.put(29, "Thunderstorm (with or without precipitation)");
        weatherMap.put(45, "Fog");
        weatherMap.put(48, "Depositing rime fog");

        weatherMap.put(30, "Slight or moderate duststorm or sandstorm - has decreased during the preceding hour");
        weatherMap.put(31, "- no appreciable change during the preceding hour");
        weatherMap.put(32, "- has begun or has increased during the preceding hour");
        weatherMap.put(33, "Severe duststorm or sandstorm - has decreased during the preceding hour");
        weatherMap.put(34, "- no appreciable change during the preceding hour");
        weatherMap.put(35, "- has begun or has increased during the preceding hour");
        weatherMap.put(36, "Slight or moderate blowing snow generally low (below eye level)");
        weatherMap.put(37, "Heavy drifting snow");
        weatherMap.put(38, "Slight or moderate blowing snow generally high (above eye level)");
        weatherMap.put(39, "Heavy drifting snow");
        weatherMap.put(40, "Fog or ice fog at a distance at the time of observation, but not at the station during the preceding hour, the fog or ice fog extending to a level above that of the observer");
        weatherMap.put(41, "Fog or ice fog in patches");
        weatherMap.put(42, "Fog or ice fog, sky visible has become thinner during the preceding hour");
        weatherMap.put(43, "Fog or ice fog, sky invisible");
        weatherMap.put(44, "Fog or ice fog, sky visible no appreciable change during the preceding hour");
        weatherMap.put(45, "Fog or ice fog, sky invisible");
        weatherMap.put(46, "Fog or ice fog, sky visible has begun or has become thicker during the preceding hour");
        weatherMap.put(47, "Fog or ice fog, sky invisible");
        weatherMap.put(48, "Fog, depositing rime, sky visible");
        weatherMap.put(49, "Fog, depositing rime, sky invisible");
        weatherMap.put(50, "Drizzle, not freezing, intermittent slight at time of observation");
        weatherMap.put(51, "Drizzle, not freezing, continuous");
        weatherMap.put(52, "Drizzle, not freezing, intermittent moderate at time of observation");
        weatherMap.put(53, "Drizzle, not freezing, continuous");
        weatherMap.put(54, "Drizzle, not freezing, intermittent heavy (dense) at time of observation");
        weatherMap.put(55, "Drizzle, not freezing, continuous");
        weatherMap.put(56, "Drizzle, freezing, slight");
        weatherMap.put(57, "Drizzle, freezing, moderate or heavy (dense)");
        weatherMap.put(58, "Drizzle and rain, slight");
        weatherMap.put(59, "Drizzle and rain, moderate or heavy");
        // Rain codes
        weatherMap.put(60, "Rain, not freezing, intermittent slight at time of observation");
        weatherMap.put(61, "Rain, not freezing, continuous");
        weatherMap.put(62, "Rain, not freezing, intermittent moderate at time of observation");
        weatherMap.put(63, "Rain, not freezing, continuous");
        weatherMap.put(64, "Rain, not freezing, intermittent heavy at time of observation");
        weatherMap.put(65, "Rain, not freezing, continuous");
        weatherMap.put(66, "Rain, freezing, slight");
        weatherMap.put(67, "Rain, freezing, moderate or heavy (dense)");
        weatherMap.put(68, "Rain or drizzle and snow, slight");
        weatherMap.put(69, "Rain or drizzle and snow, moderate or heavy");

        // Snow codes
        weatherMap.put(70, "Intermittent fall of snowflakes slight at time of observation");
        weatherMap.put(71, "Continuous fall of snowflakes");
        weatherMap.put(72, "Intermittent fall of snowflakes moderate at time of observation");
        weatherMap.put(73, "Continuous fall of snowflakes");
        weatherMap.put(74, "Intermittent fall of snowflakes heavy at time of observation");
        weatherMap.put(75, "Continuous fall of snowflakes");
        weatherMap.put(76, "Diamond dust (with or without fog)");
        weatherMap.put(77, "Snow grains (with or without fog)");
        weatherMap.put(78, "Isolated star-like snow crystals (with or without fog)");
        weatherMap.put(79, "Ice pellets");
        weatherMap.put(80, "Rain shower(s), slight");
        weatherMap.put(81, "Rain shower(s), moderate or heavy");
        weatherMap.put(82, "Rain shower(s), violent");
        weatherMap.put(83, "Shower(s) of rain and snow mixed, slight");
        weatherMap.put(84, "Shower(s) of rain and snow mixed, moderate or heavy");
        weatherMap.put(85, "Snow shower(s), slight");
        weatherMap.put(86, "Snow shower(s), moderate or heavy");
        weatherMap.put(87, "Shower(s) of snow pellets or small hail, with or without rain or rain and snow mixed - slight");
        weatherMap.put(88, "Shower(s) of snow pellets or small hail, with or without rain or rain and snow mixed - moderate or heavy");
        weatherMap.put(89, "Shower(s) of hail, with or without rain or rain and snow mixed, not associated with thunder - slight");
        weatherMap.put(90, "Shower(s) of hail, with or without rain or rain and snow mixed, not associated with thunder - moderate or heavy");
        weatherMap.put(91, "Slight rain at time of observation. Thunderstorm during the preceding hour but not at time of observation");
        weatherMap.put(92, "Moderate or heavy rain at time of observation");
        weatherMap.put(93, "Slight snow, or rain and snow mixed or hail at time of observation");
        weatherMap.put(94, "Moderate or heavy snow, or rain and snow mixed or hail at time of observation");
        weatherMap.put(95, "Thunderstorm, slight or moderate, without hail but with rain and/or snow at time of observation. Thunderstorm at time of observation");
        weatherMap.put(96, "Thunderstorm, slight or moderate, with hail at time of observation");
        weatherMap.put(97, "Thunderstorm, heavy, without hail but with rain and/or snow at time of observation");
        weatherMap.put(98, "Thunderstorm combined with duststorm or sandstorm at time of observation");
        weatherMap.put(99, "Thunderstorm, heavy, with hail at time of observation");

        
        
        return weatherMap.get(code);      
    }
}
