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
 * Locale: HU (Hungarian; Magyar)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Kötelező megadni.",
		maxlength: $.validator.format("Legfeljebb {0} karakter hosszú legyen."),
		minlength: $.validator.format("Legalább {0} karakter hosszú legyen."),
		rangelength: $.validator.format("Legalább {0} és legfeljebb {1} karakter hosszú legyen."),
		email: "Érvényes e-mail címnek kell lennie.",
		url: "Érvényes URL-nek kell lennie.",
		date: "Dátumnak kell lennie.",
		number: "Számnak kell lennie.",
		digits: "Csak számjegyek lehetnek.",
		equalTo: "Meg kell egyeznie a két értéknek.",
		range: $.validator.format("{0} és {1} közé kell esnie."),
		max: $.validator.format("Nem lehet nagyobb, mint {0}."),
		min: $.validator.format("Nem lehet kisebb, mint {0}."),
		creditcard: "Érvényes hitelkártyaszámnak kell lennie.",
		remote: "Kérem javítsa ki ezt a mezőt.",
		dateISO: "Kérem írjon be egy érvényes dátumot (ISO)."
	});
}(jQuery));