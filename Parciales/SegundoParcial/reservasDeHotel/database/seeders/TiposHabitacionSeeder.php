<?php

namespace Database\Seeders;

use App\Models\TiposHabitacion;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class TiposHabitacionSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        TiposHabitacion::factory()->count(5)->create();
    }
}
