export type Task = {
   id: bigint | null,
    name: string,
    limit_date : any,
    creation_date: any,
    estimated_duration: number,
    duration : number,
    state : {
       id: bigint | null,
        state: string
    },
    type:{
       id: bigint | null,
        type: string
    }
}

export function getEmptyTask(): Task {
    return {
        id: null,
        name: "",
        limit_date : null,
        creation_date: null,
        estimated_duration: 0,
        duration : 0,
        state : {
            id: null,
            state: ""
        },
        type:{
            id: null,
            type: ""
        }
    }

}