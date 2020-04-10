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
 * Locale: LT (Lithuanian; lietuvių kalba)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Šis laukas yra privalomas.",
		remote: "Prašau pataisyti šį lauką.",
		email: "Prašau įvesti teisingą elektroninio pašto adresą.",
		url: "Prašau įvesti teisingą URL.",
		date: "Prašau įvesti teisingą datą.",
		dateISO: "Prašau įvesti teisingą datą (ISO).",
		number: "Prašau įvesti teisingą skaičių.",
		digits: "Prašau naudoti tik skaitmenis.",
		creditcard: "Prašau įvesti teisingą kreditinės kortelės numerį.",
		equalTo: "Prašau įvestį tą pačią reikšmę dar kartą.",
		accept: "Prašau įvesti reikšmę su teisingu plėtiniu.",
		maxlength: $.format("Prašau įvesti ne daugiau kaip {0} simbolių."),
		minlength: $.format("Prašau įvesti bent {0} simbolius."),
		rangelength: $.format("Prašau įvesti reikšmes, kurių ilgis nuo {0} iki {1} simbolių."),
		range: $.format("Prašau įvesti reikšmę intervale nuo {0} iki {1}."),
		max: $.format("Prašau įvesti reikšmę mažesnę arba lygią {0}."),
		min: $.format("Prašau įvesti reikšmę didesnę arba lygią {0}.")
	});
}(jQuery));