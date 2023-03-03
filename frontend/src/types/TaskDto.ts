export type TaskDto = {
    name: string,
    limit_date : any,
    estimated_duration: number,
    type:string
}

export function getEmptyTaskDto(): TaskDto {
    return {
        name: "",
        limit_date : null,
        estimated_duration: 0,
        type:""
    }

}