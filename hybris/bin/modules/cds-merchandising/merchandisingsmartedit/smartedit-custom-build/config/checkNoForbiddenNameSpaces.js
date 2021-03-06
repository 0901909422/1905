/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
module.exports = function() {

    return {
        config: function() {
            return {
                pattern: [
                    'web/features/**/*.+(js|ts)',
                    'jsTests/**/*.+(js|ts)'
                ]
            };
        }
    };
};
