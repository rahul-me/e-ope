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
 
  
  
/**
 * Select2 Icelandic translation.
 * 
 */
(function ($) {
    "use strict";

    $.extend($.fn.select2.defaults, {
        formatNoMatches: function () { return "Ekkert fannst"; },
        formatInputTooShort: function (input, min) { var n = min - input.length; return "Vinsamlegast skrifið " + n + " staf" + (n == 1 ? "" : "i") + " í viðbót"; },
        formatInputTooLong: function (input, max) { var n = input.length - max; return "Vinsamlegast styttið texta um " + n + " staf" + (n == 1 ? "" : "i"); },
        formatSelectionTooBig: function (limit) { return "Þú getur aðeins valið " + limit + " atriði"; },
        formatLoadMore: function (pageNumber) { return "Sæki fleiri niðurstöður..."; }, 
        formatSearching: function () { return "Leita..."; }
    });
})(jQuery);
