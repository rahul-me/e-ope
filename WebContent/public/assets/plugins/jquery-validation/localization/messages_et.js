/*******************************************************************************
 * Gridscape Solutions, Inc. - CONFIDENTIAL & PROPRIETARY
 * --------------------------
 * [2015] - [2020] Gridscape Solutions, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Gridscape Solutions, Inc.
 * The intellectual and technical concepts contained
 * herein are proprietary to Gridscape Solutions, Inc.
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Gridscape Solutions.
 *******************************************************************************/
 
  
  
/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: ET (Estonian; eesti, eesti keel)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "See väli peab olema täidetud.",
		maxlength: $.validator.format("Palun sisestage vähem kui {0} tähemärki."),
		minlength: $.validator.format("Palun sisestage vähemalt {0} tähemärki."),
		rangelength: $.validator.format("Palun sisestage väärtus vahemikus {0} kuni {1} tähemärki."),
		email: "Palun sisestage korrektne e-maili aadress.",
		url: "Palun sisestage korrektne URL.",
		date: "Palun sisestage korrektne kuupäev.",
		dateISO: "Palun sisestage korrektne kuupäev (YYYY-MM-DD).",
		number: "Palun sisestage korrektne number.",
		digits: "Palun sisestage ainult numbreid.",
		equalTo: "Palun sisestage sama väärtus uuesti.",
		range: $.validator.format("Palun sisestage väärtus vahemikus {0} kuni {1}."),
		max: $.validator.format("Palun sisestage väärtus, mis on väiksem või võrdne arvuga {0}."),
		min: $.validator.format("Palun sisestage väärtus, mis on suurem või võrdne arvuga {0}."),
		creditcard: "Palun sisestage korrektne krediitkaardi number."
	});
}(jQuery));