<?php

namespace App\Filament\Resources\TiposHabitacionResource\Pages;

use App\Filament\Resources\TiposHabitacionResource;
use Filament\Actions;
use Filament\Resources\Pages\ListRecords;

class ListTiposHabitacions extends ListRecords
{
    protected static string $resource = TiposHabitacionResource::class;

    protected function getHeaderActions(): array
    {
        return [
            Actions\CreateAction::make(),
        ];
    }
}
