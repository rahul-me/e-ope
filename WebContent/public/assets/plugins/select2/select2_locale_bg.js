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
 * Select2 <Language> translation.
 * 
 * Author: Lubomir Vikev <lubomirvikev@gmail.com>
 */
(function ($) {
    "use strict";

    $.extend($.fn.select2.defaults, {
        formatNoMatches: function () { return "Няма намерени съвпадения"; },
        formatInputTooShort: function (input, min) { var n = min - input.length; return "Моля въведете още " + n + " символ" + (n == 1 ? "" : "а"); },
        formatInputTooLong: function (input, max) { var n = input.length - max; return "Моля въведете с " + n + " по-малко символ" + (n == 1? "" : "а"); },
        formatSelectionTooBig: function (limit) { return "Можете да направите до " + limit + (limit == 1 ? " избор" : " избора"); },
        formatLoadMore: function (pageNumber) { return "Зареждат се още..."; },
        formatSearching: function () { return "Търсене..."; }
    });
})(jQuery);
