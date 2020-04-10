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
 * Locale: EL (Greek; ελληνικά)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Αυτό το πεδίο είναι υποχρεωτικό.",
		remote: "Παρακαλώ διορθώστε αυτό το πεδίο.",
		email: "Παρακαλώ εισάγετε μια έγκυρη διεύθυνση email.",
		url: "Παρακαλώ εισάγετε ένα έγκυρο URL.",
		date: "Παρακαλώ εισάγετε μια έγκυρη ημερομηνία.",
		dateISO: "Παρακαλώ εισάγετε μια έγκυρη ημερομηνία (ISO).",
		number: "Παρακαλώ εισάγετε έναν έγκυρο αριθμό.",
		digits: "Παρακαλώ εισάγετε μόνο αριθμητικά ψηφία.",
		creditcard: "Παρακαλώ εισάγετε έναν έγκυρο αριθμό πιστωτικής κάρτας.",
		equalTo: "Παρακαλώ εισάγετε την ίδια τιμή ξανά.",
		accept: "Παρακαλώ εισάγετε μια τιμή με έγκυρη επέκταση αρχείου.",
		maxlength: $.validator.format("Παρακαλώ εισάγετε μέχρι και {0} χαρακτήρες."),
		minlength: $.validator.format("Παρακαλώ εισάγετε τουλάχιστον {0} χαρακτήρες."),
		rangelength: $.validator.format("Παρακαλώ εισάγετε μια τιμή με μήκος μεταξύ {0} και {1} χαρακτήρων."),
		range: $.validator.format("Παρακαλώ εισάγετε μια τιμή μεταξύ {0} και {1}."),
		max: $.validator.format("Παρακαλώ εισάγετε μια τιμή μικρότερη ή ίση του {0}."),
		min: $.validator.format("Παρακαλώ εισάγετε μια τιμή μεγαλύτερη ή ίση του {0}.")
	});
}(jQuery));