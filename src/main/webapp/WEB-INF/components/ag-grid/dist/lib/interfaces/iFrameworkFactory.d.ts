// Type definitions for ag-grid v13.3.1
// Project: http://www.ag-grid.com/
// Definitions by: Niall Crosby <https://github.com/ag-grid/>
import { ColDef } from "../entities/colDef";
import { IFilterComp } from "./iFilter";
export interface IFrameworkFactory {
    colDefFilter(colDef: ColDef): {
        new (): IFilterComp;
    } | string;
    /** Because Angular 2 uses Zones, you should not use setTimout(). So to get around this, we allow the framework
     * to specify how to execute setTimeout. The default is to just call the browser setTimeout(). */
    setTimeout(action: any, timeout?: any): void;
}
