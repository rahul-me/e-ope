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
 * Select2 Russian translation
 */
(function ($) {
    "use strict";

    $.extend($.fn.select2.defaults, {
        formatNoMatches: function () { return "Совпадений не найдено"; },
        formatInputTooShort: function (input, min) { var n = min - input.length; return "Пожалуйста, введите еще " + n + " символ" + (n == 1 ? "" : ((n > 1)&&(n < 5) ? "а" : "ов")); },
        formatInputTooLong: function (input, max) { var n = input.length - max; return "Пожалуйста, введите на " + n + " символ" + (n == 1 ? "" : ((n > 1)&&(n < 5)? "а" : "ов")) + " меньше"; },
        formatSelectionTooBig: function (limit) { return "Вы можете выбрать не более " + limit + " элемент" + (limit == 1 ? "а" : "ов"); },
        formatLoadMore: function (pageNumber) { return "Загрузка данных..."; },
        formatSearching: function () { return "Поиск..."; }
    });
})(jQuery);
