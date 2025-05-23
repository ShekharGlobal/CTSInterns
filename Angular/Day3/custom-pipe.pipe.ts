import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'customPipe'
})
export class CustomPipePipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    // Custom logic here, e.g., add "Hello" before any string
    return `Hello ${value}`;
  }

}
