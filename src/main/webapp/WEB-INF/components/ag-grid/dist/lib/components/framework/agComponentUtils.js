/**
 * ag-grid - Advanced Data Grid / Data Table supporting Javascript / React / AngularJS / Web Components
 * @version v13.3.1
 * @link http://www.ag-grid.com/
 * @license MIT
 */
"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var context_1 = require("../../context/context");
var componentMetadataProvider_1 = require("./componentMetadataProvider");
var DefaultCellRenderer = (function () {
    function DefaultCellRenderer() {
    }
    DefaultCellRenderer.prototype.init = function (params) {
        this.params = params;
    };
    DefaultCellRenderer.prototype.refresh = function (params) {
        this.params = params;
        //We update params, but still wish to be called on getGui
        return false;
    };
    DefaultCellRenderer.prototype.getGui = function () {
        var valueToUse = this.params.valueFormatted != null ? this.params.valueFormatted : this.params.value;
        if (valueToUse == null)
            return '';
        return '<span>' + valueToUse + '</span>';
    };
    return DefaultCellRenderer;
}());
exports.DefaultCellRenderer = DefaultCellRenderer;
var AgComponentUtils = (function () {
    function AgComponentUtils() {
    }
    AgComponentUtils.prototype.adaptFunction = function (propertyName, hardcodedJsFunction, type, source) {
        if (hardcodedJsFunction == null)
            return {
                component: null,
                type: type,
                source: source
            };
        var metadata = this.componentMetadataProvider.retrieve(propertyName);
        if (metadata && metadata.functionAdapter) {
            return {
                type: type,
                component: metadata.functionAdapter(hardcodedJsFunction),
                source: source
            };
        }
        console.error("It seems like you are providing a function as a component: " + hardcodedJsFunction + ", but this component: [" + propertyName + "] doesnt accept functions");
        return null;
    };
    AgComponentUtils.prototype.adaptCellRendererFunction = function (callback) {
        var Adapter = (function () {
            function Adapter() {
            }
            Adapter.prototype.refresh = function (params) {
                return false;
            };
            Adapter.prototype.getGui = function () {
                var callbackResult = callback(this.params);
                if (callbackResult == null)
                    return '';
                if (typeof callbackResult != 'string')
                    return callbackResult;
                return callbackResult;
            };
            Adapter.prototype.init = function (params) {
                this.params = params;
            };
            return Adapter;
        }());
        return Adapter;
    };
    AgComponentUtils.prototype.doesImplementIComponent = function (candidate) {
        if (!candidate)
            return false;
        return candidate.prototype && 'getGui' in candidate.prototype;
    };
    __decorate([
        context_1.Autowired("componentMetadataProvider"),
        __metadata("design:type", componentMetadataProvider_1.ComponentMetadataProvider)
    ], AgComponentUtils.prototype, "componentMetadataProvider", void 0);
    AgComponentUtils = __decorate([
        context_1.Bean("agComponentUtils")
    ], AgComponentUtils);
    return AgComponentUtils;
}());
exports.AgComponentUtils = AgComponentUtils;