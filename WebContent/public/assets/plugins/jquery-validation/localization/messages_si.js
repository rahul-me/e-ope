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
 * Locale: SI (Slovenian)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "To polje je obvezno.",
		remote: "Vpis v tem polju ni v pravi obliki.",
		email: "Prosimo, vnesite pravi email naslov.",
		url: "Prosimo, vnesite pravi URL.",
		date: "Prosimo, vnesite pravi datum.",
		dateISO: "Prosimo, vnesite pravi datum (ISO).",
		number: "Prosimo, vnesite pravo številko.",
		digits: "Prosimo, vnesite samo številke.",
		creditcard: "Prosimo, vnesite pravo številko kreditne kartice.",
		equalTo: "Prosimo, ponovno vnesite enako vsebino.",
		accept: "Prosimo, vnesite vsebino z pravo končnico.",
		maxlength: $.validator.format("Prosimo, da ne vnašate več kot {0} znakov."),
		minlength: $.validator.format("Prosimo, vnesite vsaj {0} znakov."),
		rangelength: $.validator.format("Prosimo, vnesite od {0} do {1} znakov."),
		range: $.validator.format("Prosimo, vnesite vrednost med {0} in {1}."),
		max: $.validator.format("Prosimo, vnesite vrednost manjšo ali enako {0}."),
		min: $.validator.format("Prosimo, vnesite vrednost večjo ali enako {0}.")
	});
}(jQuery));
