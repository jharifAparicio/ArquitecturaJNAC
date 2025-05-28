<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class TiposHabitacion extends Model
{
    /** @use HasFactory<\Database\Factories\TiposHabitacionFactory> */
    use HasFactory;
    protected $fillable = [
        'nombre',
        'descripcion',
        'precio',
    ];
}
